package com.github.mnemalotebya.jrtb.service;

import com.github.mnemalotebya.jrtb.javarushclient.dto.GroupDiscussionInfo;
import com.github.mnemalotebya.jrtb.repository.entity.GroupSub;

import java.util.List;
import java.util.Optional;

public interface GroupSubService {
    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
    GroupSub save(GroupSub groupSub);
    Optional<GroupSub> findById(Integer id);
    List<GroupSub> findAll();
}
