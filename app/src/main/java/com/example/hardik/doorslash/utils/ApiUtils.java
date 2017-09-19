package com.example.hardik.doorslash.utils;

import com.example.hardik.doorslash.api.GitHubClient;
import com.example.hardik.doorslash.api.RetrofitClient;

/**
 * Created by hardik
 */

public class ApiUtils {

    public static GitHubClient getGitHubClient() {
        return RetrofitClient.getInstance().getService();
    }
}
