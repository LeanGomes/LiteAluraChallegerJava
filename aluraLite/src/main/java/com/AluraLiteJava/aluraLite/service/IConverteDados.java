package com.AluraLiteJava.aluraLite.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> tClass);
}
