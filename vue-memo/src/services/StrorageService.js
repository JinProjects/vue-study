export class StorageService {
    //스토리지 이름
    #storageName;
    //생성자
    constructor(storageName) {
        if(!storageName){
            throw new Error("스토리지 이름을 입력해주세요.");
        }
        this.#storageName = storageName;

        if(localStorage.getItem(this.#storageName) === null) {
            this.addItem({title: "강의 준비물", content: "노트, 태블릿 PC"});
            this.addItem({title: "스터디 과제", content: "앱 배포, AWS 계정 생성"});
            this.addItem({title: "마트에서 살 물건", content: "감자. 두부, 계란"});
        }
    }

    #getStorageData(){
        const json = localStorage.getItem(this.#storageName);

        if(json){
            return JSON.parse(json);
        }

        return {
            items: [],
            nextId: 1
        }
    }

    #saveStorageData(obj){
        const json = JSON.stringify(obj);
        localStorage.setItem(this.#storageName, json);
    }

    addItem(item) {
        const storageData = this.#getStorageData();

        item.id = storageData.nextId++;
        storageData.items.push(item);
        this.#saveStorageData(storageData);
    }
    getItems(){
        return this.#getStorageData().items;
    }
    getItem(id){
        return this.#getStorageData().items.find(i => i.id === id);
    }
    setItem(item){
        const storageData = this.#getStorageData();

        for(let i=0; i<storageData.items.length; i++){
            if(storageData.items[i].id === item.id){
                storageData.items[i] = item;
                break;
            }
        }
    }
    //특정 항목 삭제
    delItem(id) {
        const storageData = this.#getStorageData();
        const idx = storageData.items.findIndex(i => i.id === id);

        if(idx > -1){
            storageData.items.splice(idx,1)
            this.#saveStorageData(storageData);
        }

    }
}