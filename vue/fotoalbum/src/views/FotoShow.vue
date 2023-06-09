<script>
import axios from 'axios';

import FotoComp from '../components/FotoComp.vue'

export default {
    components: {
        FotoComp
    },
    data() {
        return {
            foto: '',
            urlAddress: 'http://127.0.0.1:8080/api/v1/foto',
        }
    },
    methods: {
        getFoto() {
            axios.get(this.urlAddress + `/${this.$route.params.id}`, {
                params: {

                }
            })
                .then((response) => {
                    console.log(response.data)

                    this.foto = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },

    },
    created() {
        this.getFoto()
    },
}
</script>

<template>
    <h1>prova</h1>
    <FotoComp  :titolo="foto.titolo" :id="foto.id" :descrizione="foto.descrizione"
        :url="foto.url" :categorie="foto.categorie" :show="true" />
</template>

<style lang="scss"></style>