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
            messaggio: '',
            errors: [],
            urlAddress: 'http://127.0.0.1:8080/api/v1/foto',
            urlApiAddress: 'http://127.0.0.1:8080/api/v1'
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
        sendCommento(){
            axios.post(this.urlApiAddress + `/${this.$route.params.id}/commento`, {
                messaggio : this.messaggio
            })
                .then((response) => {
                    console.log(response)

                    this.messaggio = ''
                    
                })
                .catch(errors => {

                    console.log(errors)

                    console.log(errors.response.data.errors)

                    this.errors = errors.response.data.errors


                })
        }

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
    
    <div class="container">
        <div class="alert alert-danger mt-2" v-if="errors.length != 0">
                <p v-for="error in errors" class="mb-0">{{ error }}</p>
            </div>
         <div class="mb-3">
                <label for="messaggio" class="form-label">messaggio:</label>
                <textarea class="form-control" id="messaggio" rows="15" v-model="messaggio"></textarea>



            </div>
            <button type="submit" @click="sendCommento" class="btn btn-primary">Invia</button>
    </div>

</template>

<style lang="scss"></style>