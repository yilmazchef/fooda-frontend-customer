// eagerly import theme styles so as we can override them
import '@vaadin/vaadin-material-styles/all-imports';

const $_documentContainer = document.createElement('template');

$_documentContainer.innerHTML = `
<custom-style>
<style>
    
</style>
</custom-style>


`;

document.head.appendChild($_documentContainer.content);
