package com.github.mnemalotebya.jrtb.javarushclient;

import com.github.mnemalotebya.jrtb.javarushclient.dto.GroupDiscussionInfo;
import com.github.mnemalotebya.jrtb.javarushclient.dto.GroupInfo;
import com.github.mnemalotebya.jrtb.javarushclient.dto.GroupRequestArgs;
import com.github.mnemalotebya.jrtb.javarushclient.dto.GroupsCountRequestArgs;

import java.util.List;

public interface JavaRushGroupClient {
    List<GroupInfo> getGroupList(GroupRequestArgs requestArgs);
    List<GroupDiscussionInfo> getGroupDiscussionList(GroupRequestArgs requestArgs);
    Integer getGroupCount(GroupsCountRequestArgs countRequestArgs);
    GroupDiscussionInfo getGroupById(Integer id);
}
