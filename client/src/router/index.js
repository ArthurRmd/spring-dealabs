
import { createRouter, createWebHistory} from "vue-router"
import Home from "../views/Home";
import Deal from "../views/Deal";
import NotFound from "../views/NotFound";

const routes = [
    {
        name: 'home',
        path: '/',
        component: Home,
    },
    {
        name: 'deal',
        path: '/deal/:id',
        component: Deal,
    },
    {
        name: 'not-found',
        path: '/:pathMatch(.*)',
        component: NotFound,
    }
]


const router = createRouter({
    history: createWebHistory(),
    routes:routes
})

export default router