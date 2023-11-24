import { useEffect, useState } from 'react'
import { useCookies } from 'react-cookie'
import Navigation from '../../Navigation'
import Authentication from '../../Athentication'
import LinQMain from '../../LinQMain'
import { useUserStore } from '../../../stores'
import axios from 'axios'

export default function MainLayout() {

    const [linQResponse, setLinQResponse] = useState<String>('');
    const [cookies] = useCookies();
    const { user } = useUserStore();

    const getLinQ = async (token: String) => {
        const requestOption = {
            headers: {
                Authorization: `Bearer ${token}`
            }
        };
        await axios.get('http://localhost:4000/api/LinQ/', requestOption).then((response) => {
            setLinQResponse(response.data);
        }).catch((error) => '');
    }

    useEffect(() => {
        const token = cookies.token
        if (token) {
            getLinQ(token);
        } else
            setLinQResponse('');
    }, [cookies.token]);

    return (
        <>
            <Navigation />
            {user ? (<LinQMain />) : (<Authentication />)}
        </>
    )
}
