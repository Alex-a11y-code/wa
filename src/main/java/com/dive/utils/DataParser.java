package com.dive.utils;

import com.dive.lib.Player;
import com.dive.lib.Result;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.*;

public class DataParser {
    //定义文件路径
    private static final String PLAYERS_FILE = "players.json";
    private static final String RESULTS_DIRECTORY = "result/";

    public List<Player> getAllPlayers() throws IOException {
        try (Reader reader = new FileReader(PLAYERS_FILE)) {
            //采用Gson解析Json文件
            return new Gson().fromJson(reader, new TypeToken<List<Player>>() {
            }.getType());
        }
    }

    public List<Result> getEventResult(String eventName) throws IOException {
        String eventFileName = RESULTS_DIRECTORY + "\\" + eventName + ".json";
        File eventFile = new File(eventFileName);
        if (!eventFile.exists()) {
            throw new FileNotFoundException("Event file not found: " + eventFileName);
        }
        try (Reader reader = new FileReader(eventFileName)) {
            return new Gson().fromJson(reader, new TypeToken<List<Result>>() {
            }.getType());
        }
    }

}