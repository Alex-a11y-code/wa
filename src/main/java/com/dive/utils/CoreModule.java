package com.dive.utils;

import com.dive.lib.Player;

import java.io.FileNotFoundException;
import java.util.List;

public class CoreModule {

    private DataParser dataParser = new DataParser();
    private ResultFormatter resultFormatter = new ResultFormatter();

    public String processCommand(String command) {
        try {
            // 处理 "players" 命令
            if (command.equals("players")) {
                List<Player> players = dataParser.getAllPlayers();  // 从 JSON 文件中获取所有选手
                return resultFormatter.formatPlayers(players);  // 格式化并返回选手列表
            }
            // 处理 "result" 命令
            else if (command.startsWith("result")) {
                // 拆分命令为三个部分：result <category> <event>
                String[] parts = command.split(" ", 3);  // 仅拆分为最多三部分
                if (parts.length < 3) {
                    return "Error: Invalid result command .'";
                }

                // 拼接事件名称：category + event
                String eventName = parts[1] + " " + parts[2];

                // 读取并格式化比赛结果
                return resultFormatter.formatEventResult(dataParser.getEventResult(eventName));
            }

            // 未识别的命令
            return "Error: Invalid command";
        } catch (FileNotFoundException e) {
            return "Error: Event file not found: " + e.getMessage();  // 文件未找到错误
        } catch (Exception e) {
            return "Error: " + e.getMessage();  // 捕获所有其他异常并返回错误信息
        }
    }




}
