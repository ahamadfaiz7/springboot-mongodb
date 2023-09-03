package com.mongo.faiz.controller;

import com.mongo.faiz.entity.Video;
import com.mongo.faiz.service.VideoService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping("/show")
    public String showPage(Model model) {
        return "uploadVideo";
    }

    @PostMapping("/add")
    public String addVideo(@RequestParam("title") String title,
                           @RequestParam("file") MultipartFile file) throws IOException {
        String id = videoService.addVideo(title, file);
        return "redirect:/video/videos/" + id;
    }

    @GetMapping("/videos/{id}")
    public String getVideo(@PathVariable String id, Model model) throws Exception {
        Video video = videoService.getVideo(id);
        model.addAttribute("title", video.getTitle());
        model.addAttribute("url", "/video/videos/stream/" + id);
        return "videos";
    }

    @GetMapping("/videos/stream/{id}")
    public void streamVideo(@PathVariable String id, HttpServletResponse response) throws Exception {
        Video video = videoService.getVideo(id);
        FileCopyUtils.copy(video.getStream(), response.getOutputStream());
    }
}
