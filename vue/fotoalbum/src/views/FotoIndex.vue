<script>

import FotoComp from '../components/FotoComp.vue'

import axios from 'axios';

export default {
    components: {
        FotoComp
    },
    data() {
        return {
            apiURL: 'http://127.0.0.1:8080/api/v1/foto/filtro',
            foto: [],
            titolo: ''
        }
    },
    methods: {
        getFoto() {
            axios.get(this.apiURL, {
                params: {
                    titolo: this.titolo
                }
            })
                .then((response) => {

                    console.log(response.data);
                    this.foto = response.data;



                })
        }
    },
    created() {
        this.getFoto();
    }
}


</script>

<template>
    <main class="mt-5 pt-1">
        <div class="container">

            <div class="row">
                <div class="col-12 mt-3">
                    <input type="text" v-model="titolo" id="titolo" placeholder="cerca" @keypress="getFoto">
                </div>
            </div>

            <div class="row">
                <FotoComp v-for="foto in foto" :titolo="foto.titolo" :id="foto.id" :descrizione="foto.descrizione"
                    :url="foto.reimage" :categorie="foto.categorie"/>
            </div>


        </div>
    </main>
</template>

<style scoped lang="scss"></style>
