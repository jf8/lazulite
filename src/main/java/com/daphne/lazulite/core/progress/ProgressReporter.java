/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.core.progress;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by junfu on 2016/5/6.
 */
public class ProgressReporter implements IProgressReporter, AutoCloseable {
    private Socket m_socket;
    private PrintWriter m_out;
    private BufferedReader m_in;

    public ProgressReporter(String host, int port) throws IOException {
        this.m_socket = new Socket(host, port);
        this.m_socket.setSoTimeout(2000);
        this.m_out = new PrintWriter(this.m_socket.getOutputStream(), true);
        this.m_in = new BufferedReader(new InputStreamReader(this.m_socket.getInputStream()));
    }

    private String readResponse() {
        try {
            return this.m_in.readLine();
        } catch (IOException var1) {
            return "";
        }
    }

    public void setStatus(String status) {
        this.m_out.println("status: " + status);
        this.readResponse();
    }

    public void setDetails(String details) {
        this.m_out.println("details: " + details);
        this.readResponse();
    }

    public void addStepCount(int count) {
        this.m_out.println("add-steps: " + count);
        this.readResponse();
    }

    public void setStepCount(int count) {
        this.m_out.println("steps: " + count);
        this.readResponse();
    }

    public void incrementStep() {
        this.m_out.println("step-increment");
        this.readResponse();
    }

    public void error(String message) {
        this.m_out.println("error: " + message);
        this.readResponse();
    }

    public void close() {
        try {
            this.m_out.println("bye");
        } catch (Exception var1) {
            ;
        }

        IOUtils.closeQuietly(this.m_in);
        IOUtils.closeQuietly(this.m_out);
        IOUtils.closeQuietly(this.m_socket);
    }
}

