package net.skhu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.dto.res.Response;

@RestController
@RequestMapping("/api/ehcache")
public class EhcacheController {
    private CacheManager cacheManager;

    public EhcacheController(CacheManager cacheManager)
    {
        this.cacheManager = cacheManager;
    }

    @GetMapping("/all")
    public Response<Object> findAll(HttpServletRequest request){
        List<Map<String, String>> result = new ArrayList<>();
        /*for (String cacheName : cacheManager.getCacheNames()) {
            EhCacheCache cache = (EhCacheCache) cacheManager.getCache(cacheName);
            Ehcache ehcache = cache.getNativeCache();
            for (Object key : ehcache.getKeys()) {
                Element element = ehcache.get(key);
                if (element != null) {
                    result.add(Map.of(cacheName, element.toString()));
                }
            }
        }*/

        return Response.builder()
                .data(cacheManager.getCacheNames())
                .message("ehcache find All")
                .url(request.getRequestURI())
                .build();
    }
}