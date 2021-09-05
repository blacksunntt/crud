/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbcontext.PageviewsDao;
import dbcontext.ProductDao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author thanh
 */
public class ManageProductsController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //the number of records per one page
        int pageSize = 4;
        //the space of paging
        int pageGap = 3;
        //the current page index
        int pageIndex = 0;
        //check page index
        String pageIndexString = request.getParameter("page");
        if (pageIndexString == null) {
            pageIndexString = "1";
        }
        pageIndex = Integer.parseInt(pageIndexString);
        //count the number of quiz
        ProductDao productDao = new ProductDao();
        int num_records = productDao.countProduct();
        //caculated the number of page to pagging
        int totalPage = (num_records % pageSize == 0) ? num_records / pageSize : num_records / pageSize + 1;

        ArrayList<Product> products = productDao.getProducts(pageIndex, pageSize);

        PageviewsDao pageviewsDao = new PageviewsDao();
        pageviewsDao.updatePageviews();
        int pageviews = pageviewsDao.getPageviews();

        String notification = (String) request.getServletContext().getAttribute("message");
        request.getServletContext().setAttribute("message", "");

        request.setAttribute("notification", notification);
        request.setAttribute("pageGap", pageGap);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("products", products);
        request.setAttribute("pageviews", pageviews);

        request.getRequestDispatcher("ManageProducts.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
