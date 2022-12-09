package com.example.demoboard.controller;

import com.example.demoboard.dto.Article;
import com.example.demoboard.dto.Board;
import com.example.demoboard.repository.ArticleRepository;
import com.example.demoboard.repository.BoardRepository;
import com.example.demoboard.repository.UserRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository bRepo;
    private final ArticleRepository aRepo;
    private final UserRepository uRepo;
    private final EntityManager em;

    @GetMapping("/")
    public String index() {
        return "main";
    }

    @GetMapping("/board")
    public String boardMain(HttpServletRequest request, Model model) {
        String list = new Gson().toJson(bRepo.findAll());
        model.addAttribute("boardList", list);
        System.out.println(".......LIST >>> " + list);
        return "board";
    }

//    @GetMapping("/board/list")
//    public String getBoardList(HttpServletRequest request, Model model) {
//        String list = new Gson().toJson(bRepo.findAll());
//        model.addAttribute("boardList", list);
//        System.out.println(".......LIST >>> " + list);
//        return "boardList";
//    }

    @GetMapping("/board/new")
    public String boardNew() {
        return "new";
    }

    @PostMapping("/board/save")
    public String boardSave(HttpServletRequest request, @RequestParam Map<String, Object> params, Model model) {
        try {
            Board newBoard = new Board(params.get("title").toString(), 1);
            Article newArticle = new Article();
            newArticle.setContent(params.get("content").toString());
            newArticle.setBoard(newBoard);
            aRepo.save(newArticle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/board";
    }
}
