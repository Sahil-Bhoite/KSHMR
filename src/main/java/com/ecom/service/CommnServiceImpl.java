package com.ecom.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Implementation of CommonService for managing common functionalities.
 * Contains methods for session message handling.
 * Project developed by Sahil and Maheshwari.
 */
@Service
public class CommnServiceImpl implements CommonService {

    /**
     * Removes session messages from the current user's session.
     * Specifically removes success and error messages stored in the session.
     */
    @Override
    public void removeSessionMessage() {
        // Get the current HTTP request from the request attributes
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes()))
                .getRequest();
        
        // Obtain the current HTTP session
        HttpSession session = request.getSession();
        
        // Remove success and error messages from the session
        session.removeAttribute("succMsg");
        session.removeAttribute("errorMsg");
    }

}
