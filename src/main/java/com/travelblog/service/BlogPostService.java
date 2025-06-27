package com.travelblog.service;

import com.travelblog.model.BlogPost;
import com.travelblog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    public BlogPost updateBlogPost(Long  id, BlogPost blogPost) {
        BlogPost existingBlogPost = blogPostRepository.findById(id).orElseThrow();
        existingBlogPost.setTitle(blogPost.getTitle());
        existingBlogPost.setContent(blogPost.getContent());
        return blogPostRepository.save(existingBlogPost);
    }

    public void deleteBlogPost(Long  id) {
        blogPostRepository.deleteById(id);
    }

    public BlogPost publishBlogPost(Long id) {
        BlogPost existingBlogPost = blogPostRepository.findById(id).orElseThrow();
        existingBlogPost.setPublished(true);
        return blogPostRepository.save(existingBlogPost);
    }

    public BlogPost getBlogPostById(Long id) {
        return blogPostRepository.findById(id).orElseThrow();
    }
}
