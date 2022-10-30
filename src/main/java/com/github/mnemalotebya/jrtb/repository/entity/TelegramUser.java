package com.github.mnemalotebya.jrtb.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tg_user")
public class TelegramUser {

    @Id
    @Column(name = "chat_id")
    private String chatId;

    @Column(name = "active")
    private boolean active;
}
