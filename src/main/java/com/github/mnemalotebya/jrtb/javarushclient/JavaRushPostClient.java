package com.github.mnemalotebya.jrtb.javarushclient;

import com.github.mnemalotebya.jrtb.javarushclient.dto.PostInfo;

import java.util.List;

public interface JavaRushPostClient {
    List<PostInfo> findNewPosts(Integer groupId, Integer lastPostId);
}
