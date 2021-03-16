package com.asusoftware.wechat.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * we-chat Created by Antonio on 3/16/2021
 */
@Getter
@Setter
@ToString
public class Message {

    private String message;
    private String fromLogin;
}
