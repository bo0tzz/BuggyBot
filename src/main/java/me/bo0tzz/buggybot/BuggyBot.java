package me.bo0tzz.buggybot;

import pro.zackpollard.telegrambot.api.TelegramBot;

/**
 * Created by bo0tzz on 4-5-2016.
 */
public class BuggyBot {
    private static TelegramBot bot;

    public static void main(String[] args) {
        new BuggyBot(args);
    }

    public BuggyBot(String[] args) {
        if (args.length == 0)
            System.exit(1);

        this.bot = TelegramBot.login(args[0]);
        bot.getEventsManager().register(new BuggyBotListener());
        bot.startUpdates(false);
    }

    public static TelegramBot getBot() {
        return bot;
    }
}
