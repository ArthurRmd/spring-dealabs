
import { createRouter, createWebHistory} from "vue-router"
import Home from "../views/Home";
import Deal from "../views/deal/Deal";
import NotFound from "../views/NotFound";
import CreateDeal from "../views/deal/CreateDeal";
import Login from "../views/account/Login";
import SignUp from "../views/account/SignUp";

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