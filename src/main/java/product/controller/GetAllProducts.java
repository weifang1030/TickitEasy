package product.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import product.bean.Products;
import product.dao.ProductDao;

@WebServlet("/GetAllProducts")
public class GetAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao productDao = new ProductDao();
    public GetAllProducts() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			List<Products> product = productDao.findAll();
			request.setAttribute("product", product);
			request.getRequestDispatcher("/product/GetAllProducts.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
