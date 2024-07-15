package com.servlet.login.Controller;

import com.servlet.login.DAO.ClientDAO;
import com.servlet.login.Model.Client;
import com.servlet.login.Service.ClientAuthenticator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet({"/index", "/login", "/addNewClient", "/listAllClients", "/logout"})
public class ClientController extends HttpServlet {
    private final ClientDAO clientDAO = new ClientDAO();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        ClientAuthenticator authenticator = new ClientAuthenticator();
        Client client;

        switch (action) {
            case "/login": {
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                client = new Client(password, email);
                var authClient = authenticator.authenticate(client);
                if (authClient != null) {
                    request.getSession().setAttribute("client", authClient);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                    break;
                } else {
                    request.getSession().setAttribute("client", client);
                    request.getRequestDispatcher("loginFail.jsp").forward(request, response);
                    break;
                }
            }
            case "/addNewClient": {
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                String email = request.getParameter("email");

                client = new Client(null, name, password, email);
                if (clientDAO.existsByNameAndEmail(client)) {
                    request.setAttribute("client", client);
                    request.getRequestDispatcher("addFail.jsp").forward(request, response);
                    break;
                } else {
                    clientDAO.save(client);
                    request.getSession().setAttribute("client", client);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                    break;
                }
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        switch (action) {
            case "/index":
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "/listAllClients": {
                List<Client> clients = clientDAO.findAll();
                request.setAttribute("clients", clients);
                request.getRequestDispatcher("listAllClients.jsp").forward(request, response);
                break;
            }
            case "/login":
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case "/logout": {
                request.getSession().invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            }
        }
    }
}