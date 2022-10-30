package com.github.mnemalotebya.jrtb.service;

import com.github.mnemalotebya.jrtb.javarushclient.dto.GroupDiscussionInfo;
import com.github.mnemalotebya.jrtb.repository.entity.GroupSub;

public interface GroupSubService {
    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
}
