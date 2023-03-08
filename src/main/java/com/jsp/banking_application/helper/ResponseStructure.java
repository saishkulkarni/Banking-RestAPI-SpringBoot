package com.jsp.banking_application.helper;

import lombok.Data;

@Data
public class ResponseStructure<T>
{
int code;
String message;
T data;
}
