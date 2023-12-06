package com.ecommerce.ecommerce;

import com.ecommerce.ecommerce.Models.Category;
import com.ecommerce.ecommerce.Models.Comment;
import com.ecommerce.ecommerce.Models.Image;
import com.ecommerce.ecommerce.Models.Product;
import com.ecommerce.ecommerce.Repositories.ICategoryRepository;
import com.ecommerce.ecommerce.Repositories.ICommentRepository;
import com.ecommerce.ecommerce.Repositories.IImageRepository;
import com.ecommerce.ecommerce.Repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ICategoryRepository _categoryRepository;
    @Autowired
    private IProductRepository _productRepository;
    @Autowired
    private IImageRepository _imageRepository;
    @Autowired
    private ICommentRepository _commentRepository;


    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category(null, "Eletrônicos");
        Category category2 = new Category(null, "Roupas");
        Category category3 = new Category(null, "Livros");
        Category category5 = new Category(null, "Esportes");

        _categoryRepository.save(category1);
        _categoryRepository.save(category2);
        _categoryRepository.save(category3);
        _categoryRepository.save(category5);


        Product product1 = new Product(null, "Televisão LG", "4K 144hz", category1, 4999.98, "Nota 10", null, null);
        Product product2 = new Product(null, "Camiseta Nike", "Tamanho M, cor preta", category2, 39.99, "Ótima qualidade", null, null);
        Product product3 = new Product(null, "O Senhor dos Anéis", "Trilogia completa", category3, 89.99, "Excelente leitura", null, null);
        Product product4 = new Product(null, "Bola de Futebol Adidas", "Tamanho 5", category5, 29.99, "Durável e resistente", null, null);
        Product product5 = new Product(null, "Notebook Dell", "Core i7, 16GB RAM, 512GB SSD", category1, 2499.99, "Desempenho excepcional", null, null);
        Product product6 = new Product(null, "Fone de Ouvido Sony", "Cancelamento de ruído, sem fio", category1, 199.99, "Som de alta qualidade", null, null);
        Product product7 = new Product(null, "Calça Jeans Levi's", "Tamanho 32, cor azul", category2, 79.99, "Confortável e estilosa", null, null);
        Product product8 = new Product(null, "Tênis Adidas Ultraboost", "Tamanho 9, cor branca", category2, 129.99, "Amortecimento incrível", null, null);
        Product product9 = new Product(null, "Harry Potter e a Pedra Filosofal", "Edição especial", category3, 29.99, "Clássico da literatura fantástica", null, null);
        Product product10 = new Product(null, "Sapiens: Uma Breve História da Humanidade", "Autor: Yuval Noah Harari", category3, 34.99, "Exploração fascinante da história humana", null, null);
        Product product11 = new Product(null, "Bicicleta Mountain Bike", "21 marchas, suspensão dianteira", category5, 349.99, "Perfeita para trilhas", null, null);
        Product product12 = new Product(null, "Luvas de Boxe Everlast", "Tamanho M, cor vermelha", category5, 49.99, "Proteção e conforto durante os treinos", null, null);

        _productRepository.save(product1);
        _productRepository.save(product2);
        _productRepository.save(product3);
        _productRepository.save(product4);
        _productRepository.save(product5);
        _productRepository.save(product6);
        _productRepository.save(product7);
        _productRepository.save(product8);
        _productRepository.save(product9);
        _productRepository.save(product10);
        _productRepository.save(product11);
        _productRepository.save(product12);


        Image image1 = new Image(null, product1, 1, "https://m.media-amazon.com/images/I/51Tukq7Dn5L._AC_SX522_.jpg");
        Image image2 = new Image(null, product1, 1, "https://m.media-amazon.com/images/I/61xnLA+Vr2L._AC_SX522_.jpg");
        Image image3 = new Image(null, product1, 1, "https://m.media-amazon.com/images/I/31914ceya9L._AC_SX522_.jpg");
        Image image4 = new Image(null, product1, 1, "https://m.media-amazon.com/images/I/61wLdomHMJL._AC_SX522_.jpg");
        Image image5 = new Image(null, product1, 1, "https://m.media-amazon.com/images/I/71ObJsjXQ7L._AC_SX522_.jpg");
        Image image6 = new Image(null, product1, 1, "https://m.media-amazon.com/images/I/51gamSFhM9L._AC_SX522_.jpg");

        _imageRepository.save(image1);
        _imageRepository.save(image2);
        _imageRepository.save(image3);
        _imageRepository.save(image4);
        _imageRepository.save(image5);
        _imageRepository.save(image6);



        Comment comment1 = new Comment(null, "Edson", "Produto de ótima qualidade", product1);
        Comment comment2 = new Comment(null, "Ana Clara", "Entrega rápida", product1);


        _commentRepository.save(comment1);
        _commentRepository.save(comment2);
    }
}
