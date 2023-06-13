<script>


import axios from 'axios';

export default {
    components: {
        
    },
    data() {
        return {
            apiURL: 'http://127.0.0.1:8080/api/v1/foto',
            foto: [],
            titolo: '',
            contatore: 0,
            intervallo: null,
            apiAddress: 'http://127.0.0.1:8080/api/v1/foto',
            images: []
        }
    },
    methods: {
        getFoto() {
            axios.get(this.apiURL, {
                params: {
                    
                }
            })
                .then((response) => {

                    // console.log(response.data);
                    this.foto = response.data;



                })
        },
        avanti(){

            this.contatore++
            
            if(this.contatore == this.foto.length){
                this.contatore = 0
            }

        },
        indietro(){
            
            this.contatore--

            if(this.contatore == -1){
                this.contatore = this.foto.length - 1
            }


        },
        inzioCarosello() {
            this.intervallo = setInterval(this.avanti, 3 * 1000);
        },
        stopCarosello() {
            clearInterval(this.intervallo);
        },
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
    },
    created() {
        this.getFoto();
        this.intervallo = setInterval(this.avanti, 3 * 1000);
    }
}


</script>

<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="text-danger">Home Page</h1>
            </div>

            <div class="position-relative" @mouseover="stopCarosello" @mouseleave="inzioCarosello">

                <div v-for="foto,index in foto" class="text-center">
                    {{ getImage(foto.id) }}
                    <img :src="images[index]" alt="" :class="index == contatore ? '' : 'd-none'" class="w-50">
                </div>
                <div>
                    <button class="avanti" @click="avanti">avanti</button>
                    <button class="indietro" @click="indietro">indietro</button>
                </div>
            </div>


        </div>
    </div>
</template>

<style scoped>
    .avanti{
        position: absolute;
        top: 50%;
        right: 200px;
    }

    .indietro{
        position: absolute;
        top: 50%;
        left: 200px;
    }


</style>