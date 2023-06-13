<script>
import axios from 'axios';

export default {
    props: {
        titolo: String,
        descrizione: String,
        url: String,
        categorie: Object,
        id: Number,
        show: Boolean,
        index: Number
    },
    data() {
        return {
            apiAddress: 'http://127.0.0.1:8080/api/v1/foto',
            images: []
        }
    },
    methods:{
        getImage(id) {
            axios.get(this.apiAddress + `/${id}/image`, { responseType: 'blob' }, {
                params: {

                }
            })
                .then((response) => {

                    console.log(response.data);

                    const blob = response.data;
                    const url = URL.createObjectURL(blob);

                 

                    this.images.push(url)

                   


                })
        }
    }
    
}

</script>

<template>
    <div class="col-3 my-3">
        <div class="card" style="width: 18rem;">
            <div class="text-center">
                {{getImage(id) }}
                

                <img :src="images[index]" class="card-img-top w-50" alt="...">
            </div>
            <div class="card-body">
                <h5 class="card-title">{{ titolo }}</h5>
                <p class="card-text">{{ descrizione }}</p>
                <p class="card-text">
                    <span v-for="categoria in categorie"> #{{ categoria.titolo }} </span>
                </p>
                <router-link :to="{ name: 'fotoShow', params: { id: id } }" class="btn btn-success me-2"
                    v-if="show != true">show</router-link>
            </div>
        </div>
    </div>
</template>

<style scoped lang="scss"></style>
