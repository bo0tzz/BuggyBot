package me.bo0tzz.buggybot;

import pro.zackpollard.telegrambot.api.chat.inline.send.InlineQueryResponse;
import pro.zackpollard.telegrambot.api.chat.inline.send.content.InputTextMessageContent;
import pro.zackpollard.telegrambot.api.chat.inline.send.results.InlineQueryResultAudio;
import pro.zackpollard.telegrambot.api.event.Listener;
import pro.zackpollard.telegrambot.api.event.chat.inline.InlineQueryReceivedEvent;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by bo0tzz on 4-5-2016.
 */
public class BuggyBotListener implements Listener {

    @Override
    public void onInlineQueryReceived(InlineQueryReceivedEvent event) {

        URL url = null;
        try {
            url = new URL("http://files.bo0tzz.me/mp3/Core/Space_core_babble44.mp3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String text = "Yes. Please. Space.";
        String performer = "Core";

        InlineQueryResultAudio r = InlineQueryResultAudio.builder()
                .audioUrl(url)
                .title(text)
                .performer(performer)
                .audioDuration(1)
                .inputMessageContent(
                        InputTextMessageContent.builder()
                        .messageText(text)
                        .build()
                )
                .build();

        InlineQueryResponse response = InlineQueryResponse.builder()
                .results(r)
                .build();

        event.getQuery().answer(BuggyBot.getBot(), response);
    }
}
