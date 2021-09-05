/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbcontext.ProductDao;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author thanh
 */
@MultipartConfig
//@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024,  
//        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5) 
public class AddProductController extends HttpServlet {

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
        
        String name = request.getParameter("name").trim();
        float price = Float.parseFloat(request.getParameter("price").trim());
        String imageFileName = request.getParameter("imageFile").trim();
        
//        Part file = request.getPart("imageFile");
//        String imageFileName = file.getSubmittedFileName();  // get selected image file name
//        String uploadPath = "D:/Semester 5/LAB231 - Web Java Lab/ManageProducts/images/" + imageFileName;// upload path where we have to upload our actual image 
//        // Uploading our selected image into the images folder
//        try {
//            FileOutputStream fos = new FileOutputStream(uploadPath);
//            InputStream is = file.getInputStream();
//            byte[] data = new byte[is.available()];
//            is.read(data);
//            fos.write(data);
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        ProductDao productDao = new ProductDao();
        productDao.addProduct(name, imageFileName, price);
        request.getServletContext().setAttribute("message", "Successfully added!");
        response.sendRedirect("ManageProducts");
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
