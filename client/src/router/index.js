
import { createRouter, createWebHistory} from "vue-router"
import Home from "../views/Home";
import Deal from "../views/Deal";
import NotFound from "../views/NotFound";
import CreateDeal from "../views/CreateDeal";
import Login from "../views/Login";
import SignUp from "../views/SignUp";

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
        name: 'create-deal',
        path: '/create-deal',
        component: CreateDeal,
    },
    {
        name: 'login',
        path: '/login',
        component: Login,
    },
    {
        name: 'sign-up',
        path: '/sign-up',
        component: SignUp,
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