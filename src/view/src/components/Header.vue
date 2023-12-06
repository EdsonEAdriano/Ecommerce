<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { useRoute } from 'vue-router';

const route = useRoute();

const categories = ref([]);
const name = ref('');
let actualURL = window.location.href;
actualURL = actualURL.replace(/[?&]name=([^&#]*)/, '')

onMounted(() => {
    axios.get('http://localhost:8080/category')
        .then(response => {
            categories.value = response.data
        })
        .catch(error => {
            console.error('Error while getting categories:', error);
        })

})


</script>

<template>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Ecommerce</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            Categorias
                        </a>
                        <ul class="dropdown-menu">
                            <li v-for="c in categories"><a class="dropdown-item" :href="`/${c.name}`">{{ c.name }}</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="d-flex" role="search" @submit.prevent="search">
                    <input class="form-control me-2" type="search" placeholder="Pesquisar produto..." aria-label="Search"
                        v-model="name" />
                    <a class="btn btn-outline-success" :href="`${actualURL}?name=${name}`">Pesquisar</a>
                </form>


                <div class="cart-icon-container" style="margin-left: 10px;">
                    <button class="btn" type="button" id="cartDropdown" data-bs-toggle="dropdown"
                        aria-expanded="false">
                        <i class="bi bi-cart"></i> <img src="../Images/carrinho-de-compras.png" style="width: 20px; height: 20px;">
                        <span class="badge bg-secondary" style="margin-left: 10px;">10</span>
                    </button>

                    <!-- Dropdown do Carrinho -->
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="cartDropdown">
                        <li class="dropdown-item">Item 1 - R$10.00</li>
                        <li class="dropdown-item">Item 2 - R$20.00</li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li class="dropdown-item">Total: R$30.00</li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</template>

<style scoped>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

header {
    background-color: #333;
    color: #fff;
    padding: 10px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

#logo {
    width: 100px;
    /* Ajuste conforme necessário */
    height: auto;
}

#search-bar {
    flex-grow: 1;
    margin: 0 20px;
}

#user-photo {
    width: 30px;
    /* Ajuste conforme necessário */
    height: 30px;
    border-radius: 50%;
    margin-left: 10px;
}</style>
