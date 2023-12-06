<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { useRoute } from 'vue-router';

const route = useRoute();

const product = ref({});
const qty = ref(1);


onMounted(() => {
    axios.get(`http://localhost:8080/product/${route.params.id}`)
        .then(response => {
            product.value = response.data
        })
        .catch(error => {
            console.error('Error while getting product:', error);
        })
})

</script>

<template class="main">
    <div id="produto" class="d-flex">
        <div class="product-details flex-column">
            <h1>{{ product.name }}</h1>
            <p>{{ product.description }}</p>





            <div class="mb-3">
                <p>Preço total: R$ {{ (product.price * qty).toFixed(2) }}</p>
            </div>

            <form>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Quantidade</label>
                    <input type="number" min="1" max="999" v-model="qty" class="form-control" id="exampleInputPassword1">
                </div>
                <button type="submit" class="btn btn-primary">Adicionar ao carrinho</button>
            </form>
        </div>



        <div id="carousel" class="ml-4">
            <div id="carouselExampleIndicators" class="carousel slide">
                <div class="carousel-inner">
                    <div v-if="product.images && product.images.length > 0" v-for="(image, index) in product.images"
                        :key="image.id" :class="{ 'carousel-item': true, 'active': index === 0 }">
                        <img :src="`${image.url}`" class="img-fluid" alt="...">
                    </div>
                    <div v-else class="carousel-item active">
                        <img src="../Images/shrek.jpg" class="img-fluid" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>

        <div id="comment" class="comments flex-column">
            <h1>Comentários</h1>


            <div v-for="comment in product.comments">
                <div class="mb-3 d-flex align-items-center">
                    <img src="https://images-na.ssl-images-amazon.com/images/S/amazon-avatars-global/default._CR0,0,1024,1024_SX48_.png"
                        style="width: 30px; height: 30px;">
                    <div>
                        <p for="exampleInputPassword1" class="form-label" style="margin-left: 5px;">{{ comment.userName }}</p>

                    </div>
                </div>
                <h6>{{ comment.comment }}</h6>
            </div>


        </div>

    </div>
</template>

<style scoped>
body {
    font-family: Arial, sans-serif;
    margin: 20px;

}


#produto {
    margin: 15vh;
}

#carousel {
    padding-left: 100px;
    padding: 25px 25px 25px 250px;
}

#comment {
    background-color: white;
    padding: 15px;
    border-radius: 15px;
    margin-left: 700px;
}


.carousel-control-prev-icon {
    background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23000' viewBox='0 0 8 8'%3E%3Cpath d='M5.25 0l-4 4 4 4 1.5-1.5-2.5-2.5 2.5-2.5-1.5-1.5z'/%3E%3C/svg%3E") !important;
}

.carousel-control-next-icon {
    background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23000' viewBox='0 0 8 8'%3E%3Cpath d='M2.75 0l-1.5 1.5 2.5 2.5-2.5 2.5 1.5 1.5 4-4-4-4z'/%3E%3C/svg%3E") !important;
}




img {
    width: 600px;
    height: 400px;
}

form {
    margin-top: 20px;
}
</style>
