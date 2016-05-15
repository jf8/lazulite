/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

/**
 * 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.daphne.lazulite.personal.message.repository;

import com.daphne.lazulite.common.repository.BaseRepository;
import com.daphne.lazulite.personal.message.entity.Message;
import com.daphne.lazulite.personal.message.entity.MessageState;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>User: 
 * <p>Date: 13-5-22 下午2:39
 * <p>Version: 1.0
 */
public interface MessageRepository extends BaseRepository<Message, Long> {

    @Modifying
    @Query("update Message set senderState=?3,senderStateChangeDate=?4  where (senderId=?1 and senderState=?2)")
    int changeSenderState(Long senderId, MessageState oldState, MessageState newState, Date changeDate);

    @Modifying
    @Query("update Message set receiverState=?3,receiverStateChangeDate=?4 where  (receiverId=?1 and receiverState=?2)")
    int changeReceiverState(Long receiverId, MessageState oldState, MessageState newState, Date changeDate);


    @Modifying
    @Query("update Message set senderState=?2, senderStateChangeDate=?3 where senderState in (?1) and senderStateChangeDate<?4")
    int changeSenderState(ArrayList<MessageState> states, MessageState oldStates, Date changeDate, Date expireDate);

    @Modifying
    @Query("update Message set receiverState=?2, receiverStateChangeDate=?3 where receiverState in (?1) and receiverStateChangeDate<?4")
    int changeReceiverState(ArrayList<MessageState> oldStates, MessageState newState, Date changeDate, Date expireDate);

    @Modifying
    @Query("delete from Message where senderState=?1 and receiverState=?1")
    int clearDeletedMessage(MessageState deletedState);


    @Query("select count(o) from Message o where (receiverId=?1 and receiverState=?2 and read=false)")
    Long countUnread(Long userId, MessageState receiverState);

    @Modifying
    @Query("update Message set read=true where receiverId=?1 and id in (?2)")
    void markRead(Long userId, List<Long> ids);
}