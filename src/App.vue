<template>
  <div class="container">
    <div class="row">
      <div class="col-md-4">
        <!-- Primera sección con el botón "Generar Trabajabilidad" -->
        <div class="mb-3">
          <button class="btn btn-primary btn-lg btn-block" @click="generarTrazabilidad">Generar Trazabilidad</button>
        </div>
      </div>
      <div class="col-md-4">
        <!-- Segunda sección con los campos de entrada -->
        <div class="mb-3">
          <input type="text" class="form-control" v-model="input1" placeholder="Texto 1">
        </div>
        <div class="mb-3">
          <input type="text" class="form-control" v-model="input2" placeholder="Texto 2">
        </div>
        <div class="text-center">
          <button class="btn btn-primary" @click="llamarGetMapping">Llamar GetMapping</button>
        </div>
      </div>
      <div class="col-md-4">
        <!-- Tercera sección con el campo de fecha -->
        <div class="mb-3">
          <input type="date" class="form-control" v-model="fecha" placeholder="Fecha">
        </div>
        <div class="text-center">
          <button class="btn btn-primary" @click="llamarGetMappingFecha">Crear merma por fecha de vencimiento</button>
        </div>
      </div>
    </div>
  </div>
</template>



<script>
import axios from 'axios';

export default {
  data() {
    return {
      input1: '',
      input2: '',
      fecha: '',
      verificacionExitosa: false,
      verificacionFallida: false,
      error: '',
    };
    
  },

  methods: {
    llamarGetMapping() {
  const parametros = `${this.input1},${this.input2}`;
  axios.post('http://localhost:8080/movimientos/cambiarPrecio', parametros, {
    headers: {
      'Content-Type': 'text/plain'
    }
  })
    .then(response => {
      // Manejar la respuesta de la API
      console.log(response.data);
    })
    .catch(error => {
      // Manejar errores
      console.error(error);
    });
    alert('¡Nuevo precio actualizado Por favor revisar el txt nuevoPrecio.txt !');
},
llamarGetMappingFecha(){
  const fechaSplit = this.fecha.split('-');
      const dia = fechaSplit[2];
      const mes = fechaSplit[1];
      const anio = fechaSplit[0];
      const fechaFormateada = dia + '-' + mes + '-' + anio;
  axios.post('http://localhost:8080/movimientos/creaMerma', fechaFormateada,{
    headers: {
      'Content-Type': 'text/plain'
    }
  })
  .then(response => {
    response.data;
    console.log(response.data);
  })
      .catch(error => {
        console.error(error);
      });
      console.log(this.fecha);
     
},
generarTrazabilidad(){
  axios.post('http://localhost:8080/trasabilidad/ver')
    .then(response => {
      // Manejar la respuesta de la API
      console.log(response.data);
    })
    .catch(error => {
      // Manejar errores
      console.error(error);
    });
    alert('¡Trazabilidad generada Por favor revisar el txt Trazabilidad.txt !');
}

  }
};
</script>

<style>
.app {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  text-align: center;
}

.form {
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 10px;
  text-align: left;
}

label {
  display: block;
  font-weight: bold;
}

input {
  width: 100%;
  padding: 8px;
  font-size: 16px;
  border-radius: 4px;
  border: 1px solid #ccc;
}

.btn-submit {
  padding: 10px 20px;
  font-size: 16px;
  background-color: #4CAF50;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.mensaje-exito,
.mensaje-error {
  margin-bottom: 10px;
  padding: 10px;
  border-radius: 4px;
}

.mensaje-exito {
  background-color: #d4edda;
  color: #155724;
}

.mensaje-error {
  background-color: #f8d7da;
  color: #721c24;
}
</style>
