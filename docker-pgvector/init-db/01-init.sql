-- pgvector拡張を有効化
CREATE EXTENSION IF NOT EXISTS vector;

-- ベクトルデータを格納するテーブルを作成
CREATE TABLE IF NOT EXISTS vec (
    embedding_id UUID PRIMARY KEY, -- 各セグメントのユニークID
    embedding VECTOR(1536),        -- ベクトルデータ本体（OpenAIの場合は1536次元）
    text TEXT,                     -- 元のテキスト（PDFの一節など）
    metadata JSONB                 -- メタデータ（ファイル名やページ番号など）を構造化して保存
);

-- 高速検索のためのインデックスを作成 (HNSW形式)
-- HNSWは大規模データでも高速に近似近傍検索を行うためのアルゴリズム
CREATE INDEX ON vec USING hnsw (embedding vector_cosine_ops);
