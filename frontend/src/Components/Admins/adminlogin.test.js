import React from 'react';
import AdminLogin from './AdminLogin';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

it("render admin login correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<AdminLogin/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children).toHaveLength(5);
})
/*
    it('password check', () => {
        wrapper = shallow(<AdminLogin />);
        wrapper.find('input[type="password"]').simulate('change', { target: { name: 'password', value: '1234' } });
        expect(wrapper.find('input[type="password"]').props()).toEqual('1234');
    })

    it('AdminLogin check with correct login information', () => {
        wrapper = shallow(<AdminLogin />);
        wrapper.find('input[type="text"]').simulate('change', { target: { name: 'username', value: 'cathy' } });
        wrapper.find('input[type="password"]').simulate('change', { target: { name: 'password', value: '1234' } });
        const container = wrapper.find('button');
        expect(container.length).toEqual(1);
        container.simulate('click');
        expect(wrapper.state('hasAdminLoginFailed')).toBe(true);
    })

    it('AdminLogin check with wrong login information', () => {
        wrapper = shallow(<AdminLogin />);
        wrapper.find('input[type="text"]').simulate('change', { target: { name: 'username', value: 'cathy' } });
        wrapper.find('input[type="password"]').simulate('change', { target: { name: 'password', value: '123' } });
        const container = wrapper.find('button');
        expect(container.length).toEqual(1);
        container.simulate('click');
        expect(wrapper.state('hasAdminLoginFailed')).toBe(false);
    })
})
// it("render login page without crashing", () =>{
//     // const div = document.createElement("div");
//     // //ReactDOM.render(<Router><NavigationBarAdmin/></Router>, div);
//     // console.log(<NavigationBarAdmin/>);
//     // const { getByText } = render(<App />);
//     const tree = renderer.create(<Router><NavigationBarAdminPage/></Router>).toJSON();
//     expect(tree).toMatchSnapShot();
//     // const linkElement = getByText(/Login to manage a wide range of services!/);
//     // expect(linkElement).toBeInTheDocument();
// });

// describe('Test cases for testing AdminLogin', () => {
//     let wrapper;
//     test('username check', () => {
//         wrapper = shallow(<AdminLogin />);
//         wrapper.find('input[type="text"]').simulate('change', { target: { name: 'username', value: 'cathy' } });
//         expect(wrapper.find('input[type="text"]').props()).toEqual('cathy');
//     })
// });
*/

