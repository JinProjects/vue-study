<script setup>

import {StorageService} from "@/services/StrorageService.js";
import {useRoute, useRouter} from "vue-router";
import {reactive} from "vue";

const storageService = new StorageService("myMemo");

const router = useRouter();

const state = reactive({
  memo: {
    id: undefined,
    title: "",
    content: ""
  }
});

const route = useRoute();
const submit = () => {
  storageService.addItem(state.memo);
  if(route.params.id){
    storageService.setItem(state.memo);
  }else{
    storageService.setItem(state.memo);
  }
  window.alert("저장했습니다.");

  router.push({path:"/"});
}
(async function onCreated(){
  if(route.params.id) {
    const id = Number.parseInt(route.params.id.toString());
    state.memo = storageService.getItem(id);
  }
})();
</script>
<template>
  <form class="detail" @submit.prevent="submit">
    <div class="mb-3">
      <label for="title" class="form-label">제목</label>
      <input type="text" id="title" class="form-control p-3" v-model="state.memo.title" />
    </div>
    <div class="mb-3">
      <label for="content" class="form-label">내용</label>
      <textarea id="content" class="form-control p-3" v-model="state.memo.content"></textarea>
    </div>
    <button type="submit" class="btn btn-primary w-100 py-3">저장</button>
  </form>
</template>
