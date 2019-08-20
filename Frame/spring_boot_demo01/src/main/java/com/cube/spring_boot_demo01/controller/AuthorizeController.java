package com.cube.spring_boot_demo01.controller;

import com.cube.spring_boot_demo01.dao.User;
import com.cube.spring_boot_demo01.dao.UserMapper;
import com.cube.spring_boot_demo01.dto.AccessTokenDTO;
import com.cube.spring_boot_demo01.dto.GithubUser;
import com.cube.spring_boot_demo01.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * TODO：
 * author：Cube
 * create：2019-07-01 11:30
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @Autowired
    private UserMapper userMapper;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String ClientSecret;
    @Value("${github.redirect.uri}")
    private String RedirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state, HttpServletRequest request, HttpServletResponse response) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(ClientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(RedirectUri);
        accessTokenDTO.setState(state);
        String token = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(token);

        if (githubUser != null){
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(githubUser.getName());
            user.setAccount_id(String.valueOf(githubUser.getId()));
            user.setGMT_Create(System.currentTimeMillis());
            user.setGMT_Modified(System.currentTimeMillis());
            userMapper.inset(user);

            response.addCookie(new Cookie("token",user.getToken()));
            // 登录成功，写入cookie和session
            // request.getSession().setAttribute("user",githubUser);
            return "redirect:/";
        }else {
            // 登录失败，重新登陆
            return "redirect:/";
        }
    }
}
