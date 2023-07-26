package com.anything.s3.domain.article.presentation;

import com.anything.s3.domain.article.presentation.request.CreateArticleRequest;
import com.anything.s3.domain.article.presentation.request.EditArticleRequest;
import com.anything.s3.domain.article.presentation.response.ArticleDetailResponse;
import com.anything.s3.domain.article.presentation.response.ListArticleResponse;
import com.anything.s3.domain.article.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/article")
public class UserArticleController {

    private final CreateArticleService createArticleService;

    private final ListArticleService listArticleService;

    private final DeleteArticleService deleteArticleService;

    private final ArticleDetailService articleDetailService;

    @PostMapping
    public ResponseEntity<?> createArticle(@RequestPart("data") @Valid CreateArticleRequest articleRequest, @RequestPart("file") List<MultipartFile> files) {
        createArticleService.execute(articleRequest, files);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<ListArticleResponse> boardList() {
        var list = listArticleService.execute();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long id) {
        deleteArticleService.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<ArticleDetailResponse> getDetail(@PathVariable Long id) {
        ArticleDetailResponse detailResponse = articleDetailService.execute(id);
        return new ResponseEntity<>(detailResponse, HttpStatus.OK);
    }
}
