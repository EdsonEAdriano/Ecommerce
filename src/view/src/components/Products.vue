<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRoute } from 'vue-router';

const route = useRoute();

const products = ref([]);

const props = defineProps({
  name: String,
  category: String,
})


onMounted(() => {
    if (route.params.category && route.query.name){
      axios.get(`http://localhost:8080/product/category/${route.params.category}?name=${route.query.name}`)
      .then(response => {
        products.value = response.data
      })
    }
    else if (route.params.category) {
      axios.get(`http://localhost:8080/product/category/${route.params.category}`)
      .then(response => {
        products.value = response.data
      })
    }
    else if (route.query.name){
      axios.get(`http://localhost:8080/product?name=${route.query.name}`)
      .then(response => {
        products.value = response.data
      })
    }
    else {
      axios.get(`http://localhost:8080/product`)
      .then(response => {
        products.value = response.data
      })
    }

});

</script>

<template>

  <div class="products">
    <div class="row row-cols-1 row-cols-md-6 g-5">
      <div class="col" v-for="p in products">
        <div class="card" style="width: 18rem;">
          <img src="../Images/shrek.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title">{{ p.name }}</h5>
            <h6>{{ p.category.name }}</h6>
            <p class="card-text">{{ p.description }}</p>
            <a href="#" class="btn btn-primary">Visualizar</a>
          </div>
        </div>
      </div>
    </div>
  </div>

</template>

<style scoped>
.read-the-docs {
  color: #888;
}

.products {
  margin: 2%;
}
</style>
