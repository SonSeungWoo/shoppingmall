package com.ssw.shoppingmall.web;

import com.ssw.shoppingmall.domain.BoardRepository;
import com.ssw.shoppingmall.service.BoardService;

import org.springframework.http.HttpRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by wisebirds on 2017-05-31.
 */
@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    private final BoardRepository boardRepository;

    public BoardController(BoardService boardService, BoardRepository boardRepository) {
        this.boardService = boardService;
        this.boardRepository = boardRepository;
    }

    @GetMapping("/board_list")
    public String getBoardList(Model model,HttpSession session) {
    //public String getBoardList(Model model, @AuthenticationPrincipal User user, HttpSession session) {
        //System.out.println(session.getAttribute("id"));
        //session.setAttribute("id", user.getUsername());
        model.addAttribute("boardList", boardRepository.findAll());
        return "board/board_list";
    }

    @GetMapping("/board_write")
    public ModelAndView getBoardWrite() {
        ModelAndView md = new ModelAndView();
        md.addObject("board/board_write");
        return md;
    }
}
