import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.sse.OutboundSseEvent;
import jakarta.ws.rs.sse.Sse;
import jakarta.ws.rs.sse.SseEventSink;

import dev.langchain4j.service.TokenStream;

@Path("/ai")
public class AiResource {
    @Inject
    private TechnicalAssistant assistant;

    @GET
    @Path("/chat")
    @Produces(MediaType.SERVER_SENT_EVENTS+ ";charset=UTF-8") // SSE形式を指定
    public void streamChat(@QueryParam("msg") String msg, 
                           @Context Sse sse, 
                           @Context SseEventSink eventSink) {
        
        if (msg == null || msg.isBlank()) {
            return;
        }

        // サービスからトークンストリームを取得
        TokenStream tokenStream = assistant.chat(msg);

        // 各トークンが届いた時の処理を定義
        tokenStream
            .onPartialResponse(token -> {
                OutboundSseEvent event = sse.newEventBuilder()
                        .data(token)
                        .build();
                eventSink.send(event); // ブラウザに1文字送る
            })
            .onCompleteResponse(response -> {
                eventSink.close(); // 回答が終わったら接続を閉じる
            })
            .onError(error -> {
                error.printStackTrace();
                eventSink.close();
            })
            .start(); // ストリーミング開始！
    }
}
