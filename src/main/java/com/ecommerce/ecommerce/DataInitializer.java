package com.ecommerce.ecommerce;

import com.ecommerce.ecommerce.Models.*;
import com.ecommerce.ecommerce.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

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
    @Autowired
    private IBuyRepository _buyRepository;


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
        Image image2 = new Image(null, product1, 2, "https://m.media-amazon.com/images/I/61xnLA+Vr2L._AC_SX522_.jpg");
        Image image4 = new Image(null, product1, 3, "https://m.media-amazon.com/images/I/61wLdomHMJL._AC_SX522_.jpg");
        Image image5 = new Image(null, product1, 4, "https://m.media-amazon.com/images/I/71ObJsjXQ7L._AC_SX522_.jpg");
        Image image6 = new Image(null, product1, 5, "https://m.media-amazon.com/images/I/51gamSFhM9L._AC_SX522_.jpg");

        Image image7 = new Image(null, product2, 1, "https://imgcentauro-a.akamaihd.net/768x768/98488602A5.jpg");

        Image image8 = new Image(null, product3, 1, "https://m.media-amazon.com/images/I/715afDdgKfL._SY466_.jpg");

        Image image9 = new Image(null, product4, 1, "https://static.netshoes.com.br/produtos/bola-de-futebol-campo-adidas-ucl-club/14/FB8-9456-014/FB8-9456-014_zoom1.jpg?ts=1695699466&ims=544x");

        Image image10 = new Image(null, product5, 1, "https://m.media-amazon.com/images/I/71epkJC5SxL._AC_SX679_.jpg");

        Image image11 = new Image(null, product6, 1, "https://m.media-amazon.com/images/I/51SKmu2G9FL.__AC_SY300_SX300_QL70_ML2_.jpg");

        Image image12 = new Image(null, product7, 1, "https://m.media-amazon.com/images/I/61+1vJ3LpHL._AC_SX569_.jpg");

        Image image13 = new Image(null, product8, 1, "https://m.media-amazon.com/images/I/61okKnMpjpL._AC_SX575_.jpg");

        Image image14 = new Image(null, product9, 1, "https://m.media-amazon.com/images/I/41897yAI4LL._SY445_SX342_.jpg");

        Image image15 = new Image(null, product10, 1, "https://m.media-amazon.com/images/I/41FU42ESk5L._SY445_SX342_.jpg");

        Image image16 = new Image(null, product11, 1, "https://m.media-amazon.com/images/I/61obFU1hm1L.__AC_SX300_SY300_QL70_ML2_.jpg");

        Image image17 = new Image(null, product12, 1, "https://m.media-amazon.com/images/I/51rFoiYwr6L.__AC_SX300_SY300_QL70_ML2_.jpg");


        _imageRepository.save(image1);
        _imageRepository.save(image2);
        _imageRepository.save(image4);
        _imageRepository.save(image5);
        _imageRepository.save(image6);
        _imageRepository.save(image7);
        _imageRepository.save(image8);
        _imageRepository.save(image9);
        _imageRepository.save(image10);
        _imageRepository.save(image11);
        _imageRepository.save(image12);
        _imageRepository.save(image13);
        _imageRepository.save(image14);
        _imageRepository.save(image15);
        _imageRepository.save(image16);
        _imageRepository.save(image17);



        Comment comment1 = new Comment(null, "Edson", "Produto de ótima qualidade", product1);
        Comment comment2 = new Comment(null, "Ana Clara", "Entrega rápida", product1);


        _commentRepository.save(comment1);
        _commentRepository.save(comment2);


        Buy buy = new Buy(null, new Date(), "Comprador", 0.0);

        _buyRepository.save(buy);
    }
}
