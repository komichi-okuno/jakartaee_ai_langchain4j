# Jakarta EE × AI 実践入門：LangChain4jで実現するエンタープライズJavaの次世代化

## 概要説明

本サンプルは、以下の本で使用した、Jakarta EE アプリで LangChain4j / LangChain4j-CDI を活用するサンプルです。

[Jakarta EE × AI 実践入門：LangChain4jで実現するエンタープライズJavaの次世代化]()

This repository contains sample applications featured in the book:

"Hands-on Jakarta EE × AI: Next-Generation Enterprise Java with LangChain4j"

These samples demonstrate how to effectively integrate AI capabilities into Jakarta EE applications using LangChain4j and LangChain4j-CDI.

## 含まれているアプリの概要

### langchain4j-hello（2章）

main メソッドで最小限のコードを用いて動作させるサンプルです。

A minimalist implementation using a main method to demonstrate the basic mechanics of LangChain4j.

### langchain4j-simple（3章）

LangChain4j / LangChain4j-CDI を用いて、簡単なチャットアプリを動作させるサンプルです。

A basic chat application integrated with Jakarta EE using LangChain4j and its CDI extension.

### langchain4j-sysmsg（3章）

@SystemMessage や @UserMessage を使って、AI の役割や、AI への問い合わせのテンプレート化をするサンプルです。

Demonstrates how to use @SystemMessage and @UserMessage to define AI personas and create prompt templates.

### langchain4j-json（3章）

AI の返答を特定の JSON フォーマットで取得するサンプルです。

Examples of how to enforce and extract AI responses in specific JSON formats for structured data processing.

### langchain4j-conversation（3章）

過去の AI とのチャット履歴を一定数保持して、コンテキストを維持した会話をするためのサンプルです。

Showcases conversational memory management, allowing the AI to maintain context by retaining a specified number of past interactions.

### langchain4j-funccal（4章）

AI エージェント化して、ユーザーからのチャットに応じてサービスを呼び出すようなサンプルです。

Implementation of an "AI Agent" that utilizes Function Calling to trigger specific backend services based on user input.

### docker-pgvector（5章）

PostgreSQL でベクトルデータベースを扱う pgvector 拡張を適用したデータベースをコンテナ上につくる、Docker 用の設定ファイルです。

Docker configuration files to set up a PostgreSQL instance with the pgvector extension for handling vector databases.

### langchain4j-pgvector（5章）

PostgreSQL でベクトルデータベースを扱う pgvector 拡張を用いて、RAG を実現するサンプルです。

A practical RAG (Retrieval-Augmented Generation) implementation utilizing the pgvector database for semantic search.

### langchain4j-streaming（6章）

AI からの返答をストリーミングを用いて順次読み込むサンプルです。

Demonstrates real-time streaming responses (SSE), allowing the UI to display AI-generated text as it arrives.

## 実行環境

Eclipse / WildFly の環境で実行していますが、適宜お好きな環境にアレンジください。

These samples were developed and tested using Eclipse and WildFly. However, they are designed to be adaptable to your preferred Jakarta EE environment.
