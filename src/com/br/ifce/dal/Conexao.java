package com.br.ifce.dal;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    
    public static Connection conector(){ // Criando método com nome de: conector
java.sql.Connection conexao = null; //variável com nome de: conexao
String driver = "com.mysql.jdbc.Driver"; //chamando o driver
String url="jdbc:mysql://localhost:3306/escola"; //Armazenando informações referente ao banco
String user="root";
String password ="Senha do lucas aqui";
       try {
Class.forName(driver); //tratamento de conexão ao banco de dados
conexao = DriverManager.getConnection(url, user, password);
return conexao;
} catch (Exception e) {
return null;
}
}
    }