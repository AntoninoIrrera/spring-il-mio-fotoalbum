<script>
import axios from 'axios';

export default {
    props: {
        titolo: String,
        descrizione: String,
        url: String,
        categorie: Object,
        id: Number,
        show: Boolean
    },
    data() {
        return {

        }
    },
    
}

</script>

<template>
    <div class="col-3 my-3">
        <div class="card" style="width: 18rem;">
            <div class="text-center">
                <img :src="url" class="card-img-top w-50" alt="...">
            </div>
            <div class="card-body">
                <h5 class="card-title">{{ titolo }}</h5>
                <p class="card-text">{{ descrizione }}</p>
                <p class="card-text">
                    <span v-for="categoria in categorie"> #{{ categoria.titolo }} </span>
                </p>
                <!-- <router-link :to="{ name: 'pizzaShow', params: { id: id } }" class="btn btn-success me-2"
                    v-if="show != true">show</router-link> -->
            </div>
        </div>
    </div>
</template>

<style scoped lang="scss"></style>
