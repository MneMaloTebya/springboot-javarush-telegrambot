package com.github.mnemalotebya.jrtb.comand;

import com.github.mnemalotebya.jrtb.javarushclient.JavaRushGroupClient;
import com.github.mnemalotebya.jrtb.javarushclient.dto.GroupDiscussionInfo;
import com.github.mnemalotebya.jrtb.javarushclient.dto.GroupRequestArgs;
import com.github.mnemalotebya.jrtb.repository.entity.GroupSub;
import com.github.mnemalotebya.jrtb.service.GroupSubService;
import com.github.mnemalotebya.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;
import static org.apache.commons.lang3.StringUtils.SPACE;

import java.util.stream.Collectors;

import static com.github.mnemalotebya.jrtb.comand.CommandName.ADD_GROUP_SUB;
import static com.github.mnemalotebya.jrtb.comand.CommandUtils.getChatId;
import static com.github.mnemalotebya.jrtb.comand.CommandUtils.getMessage;
import static java.util.Objects.isNull;

public class AddGroupSubCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final JavaRushGroupClient javaRushGroupClient;
    private final GroupSubService groupSubService;

    public AddGroupSubCommand(SendBotMessageService sendBotMessageService, JavaRushGroupClient javaRushGroupClient,
                              GroupSubService groupSubService) {
        this.sendBotMessageService = sendBotMessageService;
        this.javaRushGroupClient = javaRushGroupClient;
        this.groupSubService = groupSubService;
    }

    @Override
    public void execute(Update update) {
        if (getMessage(update).equalsIgnoreCase(ADD_GROUP_SUB.getCommandName())) {
            sendGroupIdList(getChatId(update));
            return;
        }
        String groupId = getMessage(update).split(SPACE)[1];
        String chatId = getChatId(update);
        if (groupId != null && groupId.matches("[-+]?\\d*\\.?\\d+")) {
            GroupDiscussionInfo groupById = javaRushGroupClient.getGroupById(Integer.parseInt(groupId));
            if (isNull(groupById.getId())) {
                sendGroupNotFound(chatId, groupId);
            }
            GroupSub savedGroupSub = groupSubService.save(chatId, groupById);
            sendBotMessageService.sendMessage(chatId, "???????????????? ???? ???????????? " + savedGroupSub.getTitle());
        } else {
            sendNotValidGroupID(chatId, groupId);
        }
    }

    private void sendGroupNotFound(String chatId, String groupId) {
        String groupNotFoundMessage = "?????? ???????????? ?? ID = \"%s\"";
        sendBotMessageService.sendMessage(chatId, String.format(groupNotFoundMessage, groupId));
    }

    private void sendNotValidGroupID(String chatId, String groupId) {
        String groupNotFoundMessage = "???????????????????????? ID ???????????? = \"%s\"";
        sendBotMessageService.sendMessage(chatId, String.format(groupNotFoundMessage, groupId));
    }

    private void sendGroupIdList(String chatId) {
        String groupIds = javaRushGroupClient.getGroupList(GroupRequestArgs.builder().build()).stream()
                .map(group -> String.format("%s - %s \n", group.getTitle(), group.getId()))
                .collect(Collectors.joining());

        String message = "?????????? ?????????????????????? ???? ???????????? - ?????????????? ?????????????? ???????????? ?? ID ????????????. \n" +
                "????????????????: /addgroupsub 16 \n\n" +
                "?? ???????????????????? ???????????? ???????? ?????????? - ?????????????? ?????????? ???????????? :) \n\n" +
                "?????? ???????????? - ID ???????????? \n\n" +
                "%s";

        sendBotMessageService.sendMessage(chatId, String.format(message, groupIds));
    }
}

