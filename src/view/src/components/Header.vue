<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { useRoute } from 'vue-router';

const route = useRoute();

const categories = ref([]);
const items = ref([]);
const qtyItems = ref(0);
const total = ref(0);
const name = ref('');

onMounted( async () => {
    axios.get('http://localhost:8080/category')
        .then(response => {
            categories.value = response.data
        })
        .catch(error => {
            console.error('Error while getting categories:', error);
        })

    await axios.get('http://localhost:8080/item')
        .then(response => {
            items.value = response.data
        })
        .catch(error => {
            console.error('Error while getting itens:', error);
        })


    items.value.forEach(function (item) {
        qtyItems.value += item.quantity;
        total.value += item.product.price * item.quantity;
    });


})

const removeItem = async (id) => {
    await axios.delete(`http://localhost:8080/item/${id}`);
    location.reload();
}


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
                    <a class="btn btn-outline-success" :href="`http://localhost:5173?name=${name}`">Pesquisar</a>
                </form>


                <div class="cart-icon-container" style="margin-left: 10px;">
                    <button class="btn" type="button" id="cartDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="bi bi-cart"></i> <img src="../Images/carrinho-de-compras.png"
                            style="width: 20px; height: 20px;">
                        <span class="badge bg-secondary" style="margin-left: 10px;">{{ qtyItems === 0 ? '' : qtyItems }}</span>
                    </button>

                    <!-- Dropdown do Carrinho -->
                    <ul v-if="items.length > 0" class="dropdown-menu dropdown-menu-end" aria-labelledby="cartDropdown" style="width: 300px; /* Adjust the width as needed */">
                        <li v-for="i in items" style="margin-left: 5%;">{{ i.quantity }}x {{ i.product.name }} <a @click="removeItem(i.id)"><img src="../Images/excluir.png" class="removeIcon"></a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li class="dropdown-item">Total: R$ {{ total.toFixed(2) }}</li>
                    </ul>
                    <ul v-else class="dropdown-menu dropdown-menu-end" aria-labelledby="cartDropdown">
                        <li class="dropdown-item">Carrinho vazio</li>
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
}

.removeIcon {
    width:20px;
    margin-left: 44%;
    transition: transform 0.3s ease;
}

.removeIcon:hover {
    transform: scale(1.2); /* Aumenta o tamanho para 120% do tamanho original */
}
</style>
