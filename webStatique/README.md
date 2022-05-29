# AS1 - Cartes

## Communication au Serveur

### Authorisation du CORS

Lorsque l'aplication cote client envoie une requete au serveur via js, il faut penser a preciser dans le fetch que l'on ne souhaite pas appliquer la politique du COR; sinon, le web browser bloque notre requete.

Pour se faire, on utilise le code suivant:
```js
const requestOptions = {
        mode: 'no-cors',
        ...
    };
```