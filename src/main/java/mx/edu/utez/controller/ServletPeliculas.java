package mx.edu.utez.controller;

import mx.edu.utez.model.peliculas.BeanPeliculas;
import mx.edu.utez.model.peliculas.DaoPeliculas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

    @WebServlet(name = "ServletPeliculas", urlPatterns = {"/readMovies", "/createMovies", "/getMovieById", "/updateMovie", "/deleteMovie"})
public class ServletPeliculas extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(ServletPeliculas.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listPeliculas", new DaoPeliculas().findAll());
        request.getRequestDispatcher("/views/peliculas/peliculas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        switch(action){
            case "create":
                // do something
                String nombre = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
                String descripcion = request.getParameter("descripcion");
                String fechaEstreno = request.getParameter("fechaEstreno");
                int recaudacion = Integer.parseInt(request.getParameter("recaudacion"));
                int status = Integer.parseInt(request.getParameter("status"));

                BeanPeliculas beanPeliculas = new BeanPeliculas(0, nombre, descripcion, fechaEstreno, recaudacion, status);

                if(new DaoPeliculas().create(beanPeliculas)){
                    request.setAttribute("message", "Pelicula registrada correctamente");
                } else {
                    request.setAttribute("message", "Pelicula no registrada");
                }

                doGet(request, response);
                break;

            case "getUserById":
                // do something
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("user", new DaoPeliculas().findById(id));
                request.getRequestDispatcher("/views/peliculas/update.jsp").forward(request, response);
                break;
            case "update":
                // do something
                String nombre1 = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
                String descripcion1 = request.getParameter("descripcion");
                String fechaEstreno1 = request.getParameter("fechaEstreno");
                int recaudacion1 = Integer.parseInt(request.getParameter("recaudacion"));
                int status1 = Integer.parseInt(request.getParameter("status"));

                BeanPeliculas beanPeliculas1 = new BeanPeliculas(0, nombre1, descripcion1, fechaEstreno1, recaudacion1, status1);

                if(new DaoPeliculas().update(beanPeliculas1)){
                    request.setAttribute("message", "Pelicula modificada correctamente");
                } else {
                    request.setAttribute("message", "Pelicula no modificada");
                }

                doGet(request, response);
                break;
            case "delete":
                // do something
                int id2 = Integer.parseInt(request.getParameter("id"));
                if(new DaoPeliculas().delete(id2)){
                    request.setAttribute("message", "Pelicula eliminada correctamente");
                } else {
                    request.setAttribute("message", "Pelicula no eliminada");
                }
                doGet(request, response);
                break;
            default:
                // no supported
                break;
        }
    }
}